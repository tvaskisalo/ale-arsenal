import {
	createBrowserRouter,
	createRoutesFromElements,
	Route,
} from 'react-router-dom'

import IngredientForm from './components/forms/Ingredient-form.tsx'
import Header from './components/header/Header.tsx'
import MainPage from './pages/Main-page.tsx'
import { Paths } from './paths'

export const routes = createBrowserRouter(
	createRoutesFromElements(
		<Route path={Paths.ROOT}>
			<Route element={<Header />}>
				<Route path={Paths.ROOT} element={<MainPage />} />
				<Route path={Paths.INGREDIENT_FORM} element={<IngredientForm />} />
			</Route>
		</Route>,
	),
)
