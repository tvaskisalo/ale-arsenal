import { render, screen } from '@testing-library/react'
import { describe, expect, test } from 'vitest'

import App from '../App'

describe('dummyTest', () => {
	test('Render app', () => {
		render(<App />)
		expect(screen.getByText('Vite + React')).toBeDefined()
	})
})
