import Config from "../../client/Config";

class Media{

	static getUrl(file){
		return `${Config.MEDIA_URL}/${file}`;
	}

}

export default Media;