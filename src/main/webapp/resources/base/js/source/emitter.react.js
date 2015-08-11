/**
 Bản quyền thuộc về Viettel-ICT
 
 Mọi hành vi của cá nhân hay tổ chức sử dụng, sao chép toàn bộ mã nguồn 
 hay một phần mã nguồn, tạo các phiên bản triển khai (build, deploy) 
 dù với mục đích thương mại hay phi thương mại mà chưa được sự cho phép 
 của nhóm tác giả đều là vi phạm nghiêm trọng tác quyền. 
 
 Nhóm tác giả giữ toàn bộ bản quyền nhưng không chịu trách nhiệm, 
 hay liên quan đến những vấn để phát sinh khi cá nhân hay tổ chức 
 sử dụng một phần hay toàn bộ mã nguồn này mà chưa được phép của nhóm tác giả.
 
 Hà Nội 2014
 */

/**
 * Broadcast các sự kiện thay đổi ở trên các component để xử lý các vấn đề khác
 * Khi một sự kiện nào đó xẩy ra nó sẽ gọi 1 hàm, được mô tả trong đây để thông báo
 * Các component cũng có thể tạo ra các hàm ở đây để đón các sự kiện tay đổi
 */
var Emitter = {
	
	/**
	 * Sự kiện muốn thông báo đến các component khác khi trả lại văn bản
	 * @param  {[type]} documentReceive [description]
	 * @return {[type]}                 [description]
	 */
	returnDocument : function(documentReceive){
		console.log("returnDocument");
	},

	/**
	 * Thông báo là văn bản đã thu hồi
	 * @param  {[type]} documentReceive [Văn bản]
	 * @param  {[type]} transferAll     [Thu hồi hết hoặc thu hồi 1 phần]
	 * @return {[type]}                 [description]
	 */
	revokeDocument : function(documentReceive, transferAll){
		console.log("revokeDocument");
	}

};