import React, { useState } from 'react'

function MainPage() {
	const [count, setCount] = useState(0)
	const [msg, setMsg] = useState('')
	const pingBackend = async (e: React.MouseEvent) => {
		e.preventDefault()
		const message = await fetch('http://0.0.0.0:8080/')
		const text = await message.text()
		setMsg(text)
	}
	return (
		<>
			<h1>Vite + React</h1>
			<div className="card">
				<button onClick={() => setCount((count) => count + 1)}>
					count is {count}
				</button>
			</div>
			<button onClick={pingBackend}>PING</button>
			<div>{msg}</div>
		</>
	)
}

export default MainPage
