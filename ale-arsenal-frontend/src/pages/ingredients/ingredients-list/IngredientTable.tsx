import { useState } from 'react'
import { useLoaderData } from 'react-router-dom'

import Dialog from '../../../components/dialog/Dialog.tsx'
import Table, { TableType } from '../../../components/list/Table.tsx'
import { Ingredient } from '../../../types/ingredient-types.ts'
import IngredientForm from '../ingredient-form/Ingredient-form.tsx'

const IngredientTable = () => {
	const [showModal, setShowModal] = useState<boolean>(false)
	const ingredients = useLoaderData() as Ingredient[]
	const fieldNames = ['Name', 'Type', 'Amount']
	return (
		<>
			<Table
				listType={TableType.INGREDIENT}
				data={ingredients}
				fieldNames={fieldNames}
			/>
			<button onClick={() => setShowModal(!showModal)}>Add ingredient</button>
			<Dialog
				title={'Add ingredient'}
				isOpen={showModal}
				onClose={() => {
					setShowModal(false)
				}}
			>
				<IngredientForm />
			</Dialog>
		</>
	)
}
export default IngredientTable
