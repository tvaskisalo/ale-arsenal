import { zodResolver } from '@hookform/resolvers/zod'
import { ReactNode } from 'react'
import {
	FieldValues,
	SubmitHandler,
	useForm,
	UseFormRegister,
} from 'react-hook-form'
import {
	z,
	ZodNumber,
	ZodOptional,
	ZodRawShape,
	ZodString,
	ZodTypeAny,
} from 'zod'

import Form, { FormType } from '../form/Form'
import TextInput from '../text-input/Text-input'

interface FormGeneratorProps<T extends FieldValues> {
	schema: z.ZodObject<ZodRawShape>
	formType: FormType
	onSubmit: SubmitHandler<T>
}
enum FieldType {
	STRING = 'string',
	NUMBER = 'number',
	UNKNOWN = 'unknown',
}

interface FieldData {
	name: string
	isOptional: boolean
	isNullable: boolean
	type: FieldType
}

const getFieldType = (field: ZodTypeAny): FieldType => {
	if (field instanceof ZodOptional) {
		return getFieldType(field._def.innerType as ZodTypeAny)
	}

	if (field instanceof ZodString) {
		return FieldType.STRING
	}

	if (field instanceof ZodNumber) {
		return FieldType.NUMBER
	}

	return FieldType.UNKNOWN
}

const parseField = (name: string, field: ZodTypeAny): FieldData => {
	return {
		name: name,
		isOptional: field.isOptional(),
		isNullable: field.isNullable(),
		type: getFieldType(field),
	}
}

const parseSchemaToFieldData = (
	schema: z.ZodObject<ZodRawShape>,
): FieldData[] => {
	const fields: FieldData[] = []
	for (const name in schema.shape) {
		const field = parseField(name, schema.shape[name])
		fields.push(field)
	}
	return fields
}

interface InputFieldProps<T extends FieldValues> {
	fieldData: FieldData
	register: UseFormRegister<T>
}

const InputField = <T extends FieldValues>({
	fieldData,
	register,
}: InputFieldProps<T>): ReactNode => {
	switch (fieldData.type) {
		case FieldType.NUMBER:
			return (
				<TextInput
					register={register}
					label={fieldData.name}
					field={fieldData.name}
					isNumber={true}
					key={fieldData.name}
				/>
			)
		case FieldType.STRING:
			return (
				<TextInput
					register={register}
					label={fieldData.name}
					field={fieldData.name}
					key={fieldData.name}
				/>
			)
		case FieldType.UNKNOWN:
			return <div>UNKNOWN</div>
		default:
			return <div>DEFAULT</div>
	}
}

const FormGenerator = <T extends FieldValues>({
	schema,
	formType,
	onSubmit,
}: FormGeneratorProps<T>) => {
	const { register, handleSubmit } = useForm<T>({
		resolver: zodResolver(schema),
	})
	const fieldData = parseSchemaToFieldData(schema)
	return (
		<Form onSubmit={handleSubmit(onSubmit)} formType={formType}>
			{fieldData.map((field) => (
				<InputField fieldData={field} register={register} key={field.name} />
			))}
		</Form>
	)
}

export default FormGenerator
