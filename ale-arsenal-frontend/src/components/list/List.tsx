import ListRow from './ListRow.tsx'

export enum ListType {
	INGREDIENT,
	OWN_BEER,
}

export interface ListProps<T> {
	data: T[]
	listType: ListType
}

const List = ({ data, listType }: ListProps<unknown>) => {
	return (
		<ul>
			{data.map((value, index) => (
				<ListRow key={index} listType={listType} data={value} />
			))}
		</ul>
	)
}

export default List
