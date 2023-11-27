/** @type {import('tailwindcss').Config} */
export default {
	content: ['./index.html', './src/**/*.{js,ts,jsx,tsx}'],
	theme: {
		extend: {
			colors: {
				red: '#cc0000',
				'red-400': '#dc2626',
				darkgrey: '#0f0f0f',
			},
		},
	},
	plugins: [],
}
