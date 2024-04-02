/* eslint-disable no-console */
import { z, ZodRawShape, ZodTypeAny } from 'zod'

interface FormGeneratorProps {
	schema: z.ZodObject<ZodRawShape>
}

interface FieldData {
	name: string
	isOptional: boolean
	isNullable: boolean
	type: string
}

const parseField = (name: string, field: ZodTypeAny): FieldData => {
	return {
		name: name,
		isOptional: field.isOptional(),
		isNullable: field.isNullable(),
		type:
			field._def.innerType === undefined
				? field._def.typeName
				: field._def.innerType._def.typeName,
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

const FormGenerator = ({ schema }: FormGeneratorProps) => {
	const fields = parseSchemaToFieldData(schema)
	fields.map((field) => console.log(field))
	return <div></div>
}

export default FormGenerator
