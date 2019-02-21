package m.vk.k003_listadapter.model

import m.vk.k003_listadapter.constant.PostType

class StatusPost(id: String, text: String, timestamp: String) : Post(id, text, timestamp, PostType.STATUS) {

}