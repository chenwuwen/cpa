package cn.kanyun.cpa.pojo;
/*模型驱动，用于返回字符串数据*/
public class CpaResult<T> implements java.io.Serializable {
	public int status;//状态  0:代表未找到，1:代表成功，2:代表失败
	public String msg;//消息
	public Object data;//数据
	public Long TotalCount;//总记录数
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Long getTotalCount() {
		return TotalCount;
	}
	public void setTotalCount(Long totalCount) {TotalCount = totalCount;}

	}
	

