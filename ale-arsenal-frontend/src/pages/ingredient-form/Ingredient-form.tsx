import { zodResolver } from '@hookform/resolvers/zod'
import { SubmitHandler, useForm } from 'react-hook-form'

import TextInput from '../../components/text-input/Text-input.tsx'
import { addIngredientSchema } from '../../schemas/ingredient-schemas.ts'
import { addIngredient } from '../../services/ingredient-service.ts'
import { addIngredientCommand } from '../../types/ingredient-types.ts'

const IngredientForm = () => {
	const { register, handleSubmit } = useForm<addIngredientCommand>({
		resolver: zodResolver(addIngredientSchema),
	})
	const onSubmit: SubmitHandler<addIngredientCommand> = async (data) => {
		const id = await addIngredient(data)
		// eslint-disable-next-line no-console
		console.log(id)
	}
	return (
		<form onSubmit={handleSubmit(onSubmit)} className={'w-1/12'}>
			<TextInput register={register} label={'Name'} field={'name'} />
			<TextInput
				register={register}
				label={'Amount'}
				field={'amount'}
				isNumber={true}
			/>
			<TextInput
				register={register}
				label={'Ingredient type'}
				field={'ingredientType'}
			/>
			<input type="submit" />
		</form>
	)
}

export default IngredientForm
