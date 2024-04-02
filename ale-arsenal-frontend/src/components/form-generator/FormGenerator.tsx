/* eslint-disable no-console */
import { z, ZodNumber, ZodOptional, ZodRawShape, ZodString, ZodTypeAny } from 'zod'

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
	console.log('Field type')
	console.log(field instanceof ZodString)
	let type = ''
	if (field instanceof ZodString) {
		type = 'string'
	} else if (field instanceof ZodOptional) {
		if (field._def.innerType instanceof ZodNumber) {
			type = 'number'
		}
	}
	return {
		name: name,
		isOptional: field.isOptional(),
		isNullable: field.isNullable(),
		type: type,
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
