import List, { ListType } from '../../../components/list/List.tsx'

const IngredientList = () => {
	return <List listType={ListType.INGREDIENT} data={[1, 2]} />
}

export default IngredientList
