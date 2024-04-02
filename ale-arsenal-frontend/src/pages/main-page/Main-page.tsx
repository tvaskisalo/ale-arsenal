/* eslint-disable no-console */
import React, { useState } from 'react'

import { api } from '../../services/api.tsx'

function MainPage() {
	const [count, setCount] = useState(0)

	const pingBackend = (e: React.MouseEvent) => {
		e.preventDefault()
		api
			.apiIngredientGet()
			.then((data) => console.log(data))
			.catch((err) => console.error(err))
	}
	return (
		<div className={'flex flex-col'}>
			<h1 className="text-3xl font-bold underline text-red">Vite + React</h1>
			<div className="card">
				<button onClick={() => setCount((count) => count + 1)}>
					count is {count}
				</button>
			</div>
			<button onClick={pingBackend}>PING</button>
			<div>CHECK LOGS</div>
		</div>
	)
}

export default MainPage
