import React, { ReactNode } from 'react'

export enum FormType {
	OWN_BEER = 'own beer',
	INGREDIENT = 'ingreident',
}

interface FormProps {
	children: ReactNode
	formType: FormType
	onSubmit: (event: React.BaseSyntheticEvent) => Promise<void>
}
const Form = ({ children, formType, onSubmit }: FormProps) => {
	return (
		<form
			onSubmit={(event) => {
				void onSubmit(event)
			}}
			className={'w-4/12 p-10'}
		>
			{children}
			<button
				type="submit"
				data-testid={`submit-form`}
			>{`Add new ${formType}`}</button>
		</form>
	)
}

export default Form
