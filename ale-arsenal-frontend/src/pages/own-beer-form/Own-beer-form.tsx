import { SubmitHandler } from 'react-hook-form'

import { FormType } from '../../components/form/Form.tsx'
import FormGenerator from '../../components/form-generator/FormGenerator.tsx'
import { addOwnBeerSchema } from '../../schemas/own-beer-schemas.ts'
import { addOwnBeer } from '../../services/own-beer-service.ts'
import { addOwnBeerCommand } from '../../types/own-beer-types.ts'

const OwnBeerForm = () => {
	//const { register, handleSubmit } = useForm<addOwnBeerCommand>({
	//	resolver: zodResolver(addOwnBeerSchema),
	//})
	const onSubmit: SubmitHandler<addOwnBeerCommand> = async (data) => {
		const id = await addOwnBeer(data)
		// eslint-disable-next-line no-console
		console.log(id)
	}
	return (
		<FormGenerator
			schema={addOwnBeerSchema}
			formType={FormType.OWN_BEER}
			onSubmit={onSubmit}
		/>
	)
	//	<Form onSubmit={handleSubmit(onSubmit)} formType={FormType.OWN_BEER}>
	//		<TextInput register={register} label={'Name'} field={'name'} />
	//		<TextInput
	//			register={register}
	//			label={'Bottle size'}
	//			field={'bottleSize'}
	//			isNumber={true}
	//		/>
	//		<TextInput
	//			register={register}
	//			label={'Keg size'}
	//			field={'kegSize'}
	//			isNumber={true}
	//		/>
	//		<TextInput
	//			register={register}
	//			label={'Bottle amount'}
	//			field={'bottleAmount'}
	//			isNumber={true}
	//		/>
	//		<TextInput
	//			register={register}
	//			label={'Abv'}
	//			field={'abv'}
	//			isNumber={true}
	//		/>
	//		<TextInput register={register} label={'Beer style'} field={'style'} />
	//		<TextInput register={register} label={'Brew Date'} field={'brewDate'} />
	//		<TextInput
	//			register={register}
	//			label={'Description'}
	//			field={'description'}
	//		/>
	//	</Form>
}

export default OwnBeerForm
