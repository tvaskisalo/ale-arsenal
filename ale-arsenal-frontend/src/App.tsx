import { RouterProvider } from 'react-router-dom'

import FormGenerator from './components/form-generator/FormGenerator'
import { routes } from './routes'
import { addOwnBeerSchema } from './schemas/own-beer-schemas'

const App = () => {
	FormGenerator({ schema: addOwnBeerSchema })
	return <RouterProvider router={routes} />
}

export default App
