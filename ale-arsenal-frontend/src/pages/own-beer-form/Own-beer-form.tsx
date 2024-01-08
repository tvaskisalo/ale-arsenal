import { zodResolver } from '@hookform/resolvers/zod'
import { SubmitHandler, useForm } from 'react-hook-form'

import TextInput from '../../components/text-input/Text-input.tsx'
import { addOwnBeerSchema } from '../../schemas/own-beer-schemas.ts'
import { addOwnBeer } from '../../services/own-beer-service.ts'
import { addOwnBeerCommand } from '../../types/own-beer-types.ts'

const OwnBeerForm = () => {
	const { register, handleSubmit } = useForm<addOwnBeerCommand>({
		resolver: zodResolver(addOwnBeerSchema),
	})
	const onSubmit: SubmitHandler<addOwnBeerCommand> = async (data) => {
		const id = await addOwnBeer(data)
		// eslint-disable-next-line no-console
		console.log(id)
	}
	return (
		<form onSubmit={handleSubmit(onSubmit)} className={'w-1/12'}>
			<TextInput register={register} label={'Name'} field={'name'} />
			<TextInput
				register={register}
				label={'Bottle size'}
				field={'bottleSize'}
				isNumber={true}
			/>
			<TextInput
				register={register}
				label={'Keg size'}
				field={'kegSize'}
				isNumber={true}
			/>
			<TextInput
				register={register}
				label={'Bottle amount'}
				field={'bottleAmount'}
				isNumber={true}
			/>
			<TextInput
				register={register}
				label={'Abv'}
				field={'abv'}
				isNumber={true}
			/>
			<TextInput register={register} label={'Beer style'} field={'style'} />
			<TextInput register={register} label={'Brew Date'} field={'brewDate'} />
			<TextInput
				register={register}
				label={'Description'}
				field={'description'}
			/>
			<input type="submit" />
		</form>
	)
}

export default OwnBeerForm
