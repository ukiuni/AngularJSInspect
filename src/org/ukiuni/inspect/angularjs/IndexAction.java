package org.ukiuni.inspect.angularjs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.arnx.jsonic.JSON;

import org.ukiuni.inspect.angularjs.entity.Memo;

@Path("/")
public class IndexAction {
	private static List<Memo> memos = new ArrayList<Memo>();

	@GET
	@Path("/loadMemos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Memo> loadMemo() {
		if (memos.isEmpty()) {
			memos.add(new Memo(1, "test1"));
			memos.add(new Memo(2, "test2"));
			memos.add(new Memo(3, "test3"));
		}
		return memos;
	}

	@PUT
	@Path("/putMemos")
	@Produces(MediaType.APPLICATION_JSON)
	public void put(String body) {
		Memo[] memos = JSON.decode(body, Memo[].class);
		System.out.println("memos.length = " + memos.length);
		for (Memo memo : memos) {
			if (0 == memo.getId()) {
				System.out.println("insert = " + memo.getText());
				// insert
			} else {
				System.out.println("update" + memo.getText());
				// update
			}
		}
		IndexAction.memos = Arrays.asList(memos);
		// put Message
	}
}
