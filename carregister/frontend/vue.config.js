module.exports = {
	"devServer": {
		"proxy": "http://localhost:8099/"
	},
	"runtimeCompiler": true,
	"publicPath": '/',
	"outputDir": "../backend/src/main/resources/static",
	"transpileDependencies": [
		"vuetify"
	]
}
