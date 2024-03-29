import {
	createBrowserRouter,
	createRoutesFromElements,
	Route,
} from 'react-router-dom'

import Header from './components/header/Header.tsx'
import IngredientForm from './pages/ingredients/ingredient-form/Ingredient-form.tsx'
import IngredientTable from './pages/ingredients/ingredients-list/IngredientTable.tsx'
import MainPage from './pages/main-page/Main-page.tsx'
import OwnBeerForm from './pages/own-beer-form/Own-beer-form.tsx'
import { Paths } from './paths'
import { getIngredients } from './services/ingredient-service.ts'

export const routes = createBrowserRouter(
	createRoutesFromElements(
		<Route path={Paths.ROOT}>
			<Route element={<Header />}>
				<Route path={Paths.ROOT} element={<MainPage />} />
				<Route path={Paths.INGREDIENT_FORM} element={<IngredientForm />} />
				<Route
					path={Paths.VIEW_INGREDIENTS}
					element={<IngredientTable />}
					loader={getIngredients}
				/>
				<Route path={Paths.OWN_BEER_FORM} element={<OwnBeerForm />} />
			</Route>
		</Route>,
	),
)
