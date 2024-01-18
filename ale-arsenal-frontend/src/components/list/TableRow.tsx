import { Ingredient } from '../../types/ingredient-types.ts'
import { TableItem, TableType } from './Table.tsx'

export interface TableRowProps<T> {
	data: T
	listType: TableType
}

const TableRow = ({ data, listType }: TableRowProps<unknown>) => {
	switch (listType) {
		case TableType.INGREDIENT: {
			const ingredient = data as Ingredient
			return (
				<tr className="border-2 border-gray-500">
					<TableItem content={ingredient.name} />
					<TableItem content={ingredient.ingredientType} />
					<TableItem content={ingredient.amount.toString()} />
				</tr>
			)
		}
		case TableType.OWN_BEER: {
			return <div>OWN BEER</div>
		}
		default: {
			throw Error('INCORRECT LIST TYPE')
		}
	}
}

export default TableRow
