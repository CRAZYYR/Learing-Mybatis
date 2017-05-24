package javabean;
/**
 * 
 * @author Go With Me
 *
 */
public class Message {
	private String	id;
	private String	command;
	private String	desc;
	private String	content;
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
