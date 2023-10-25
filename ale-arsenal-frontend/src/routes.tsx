import {
	createBrowserRouter,
	createRoutesFromElements,
	Route,
} from 'react-router-dom'

import MainPage from './pages/MainPage'
import { Paths } from './paths'

export const routes = createBrowserRouter(
	createRoutesFromElements(
		<>
			<Route path={Paths.ROOT} element={<MainPage />} />
		</>,
	),
)
