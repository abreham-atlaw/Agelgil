
class Config{

	static BACKEND_URL = "http://localhost:8080"

	static API_URL = `${Config.BACKEND_URL}/api/client`

	static MEDIA_URL = `${Config.BACKEND_URL}/media`
	
}

export default Config;