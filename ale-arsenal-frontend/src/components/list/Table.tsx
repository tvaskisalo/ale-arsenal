import TableRow from './TableRow.tsx'

export enum TableType {
	INGREDIENT,
	OWN_BEER,
}

export interface TableProps {
	data: object[]
	listType: TableType
	fieldNames: string[]
}

interface TableHeaderProps {
	fieldNames: string[]
}

interface TableItemProps {
	content: string
}
export const TableItem = ({ content }: TableItemProps) => {
	return <td className={'px-4'}> {content}</td>
}
const TableHeader = ({ fieldNames }: TableHeaderProps) => {
	return (
		<thead className={'bg-gray-500'}>
			<tr>
				{fieldNames.map((field) => (
					<TableItem content={field} key={field} />
				))}
			</tr>
		</thead>
	)
}

const Table = ({ data, listType, fieldNames }: TableProps) => {
	return (
		<table className={'table-fixed w-full max-w-4xl'}>
			<TableHeader fieldNames={fieldNames} />
			<tbody>
				{data.map((value, index) => (
					<TableRow key={index} listType={listType} data={value} />
				))}
			</tbody>
		</table>
	)
}

export default Table
