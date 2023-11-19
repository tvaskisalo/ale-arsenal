import React, { useState } from 'react'

import { api } from '../services/api.tsx'

function MainPage() {
	const [count, setCount] = useState(0)

	const pingBackend = async (e: React.MouseEvent) => {
		e.preventDefault()
		const ingredients = await api.apiIngredientGet()
		// eslint-disable-next-line no-console
		console.log(ingredients)
	}
	return (
		<>
			<h1 className="text-3xl font-bold underline text-red-600">
				Vite + React
			</h1>
			<div className="card">
				<button onClick={() => setCount((count) => count + 1)}>
					count is {count}
				</button>
			</div>
			<button onClick={pingBackend}>PING</button>
			<div>CHECK LOGS</div>
		</>
	)
}

export default MainPage
