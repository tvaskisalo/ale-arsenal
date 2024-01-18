import { useLoaderData } from 'react-router-dom'

import Table, { TableType } from '../../../components/list/Table.tsx'
import { Ingredient } from '../../../types/ingredient-types.ts'
const IngredientTable = () => {
	const ingredients = useLoaderData() as Ingredient[]
	const fieldNames = ['Name', 'Type', 'Amount']
	return (
		<Table
			listType={TableType.INGREDIENT}
			data={ingredients}
			fieldNames={fieldNames}
		/>
	)
}

export default IngredientTable
