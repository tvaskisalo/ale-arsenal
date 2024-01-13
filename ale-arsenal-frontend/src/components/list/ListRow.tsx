import { ListType } from './List.tsx'

export interface ListRowProps<T> {
	data: T
	listType: ListType
}

const ListRow = ({ listType }: ListRowProps<unknown>) => {
	switch (listType) {
		case ListType.INGREDIENT: {
			return <div>INGREDIENT</div>
		}
		case ListType.OWN_BEER: {
			return <div>OWN BEER</div>
		}
		default: {
			throw Error('INCORRECT LIST TYPE')
		}
	}
}

export default ListRow
