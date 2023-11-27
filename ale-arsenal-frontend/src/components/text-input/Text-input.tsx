import { UseFormRegister } from 'react-hook-form'

export interface TextInputProps {
	// eslint-disable-next-line @typescript-eslint/no-explicit-any
	register: UseFormRegister<any>
	label: string
	field: string
	isNumber?: boolean
}

const TextInput = ({ register, label, field, isNumber }: TextInputProps) => {
	return (
		<div className={'flex flex-row w-fill pt-2 items-stretch'}>
			<label
				htmlFor="name"
				className={'pr-5 min-w-full'}
				id={`${field}-label`}
				data-testid={`${field}-label`}
			>
				{label}
			</label>
			<input
				{...register(field, { valueAsNumber: isNumber ?? false })}
				id={field}
				data-testid={field}
				className={
					'rounded caret-red bg-gray-500 p-1 outline outline-0 focus:outline-0 focus:border-2 focus:border-pink-500'
				}
			/>
		</div>
	)
}

export default TextInput
