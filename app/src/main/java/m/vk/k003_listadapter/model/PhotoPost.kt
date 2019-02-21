package m.vk.k003_listadapter.model

import m.vk.k003_listadapter.constant.PostType

class PhotoPost(override var id: String, override var text: String, override var timestamp: String, var url: String) : Post(id, text, timestamp, PostType.PHOTO)