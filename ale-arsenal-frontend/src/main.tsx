import './index.css'

import React from 'react'
import ReactDOM from 'react-dom/client'

import { App } from './App'
import { DefaultApiFactory } from './generated'

export const api = DefaultApiFactory(undefined, 'http://0.0.0.0:8080')

ReactDOM.createRoot(document.getElementById('root')!).render(
	<React.StrictMode>
		<App />
	</React.StrictMode>,
)
