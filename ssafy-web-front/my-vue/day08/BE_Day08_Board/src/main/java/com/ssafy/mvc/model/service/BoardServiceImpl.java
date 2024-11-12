package com.ssafy.mvc.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;
	private final ResourceLoader resourceLoader;

	public BoardServiceImpl(BoardDao boardDao, ResourceLoader resourceLoader) {
		this.boardDao = boardDao;
		this.resourceLoader = resourceLoader;
	}

	@Override
	public List<Board> getBoardList() {
		System.out.println("모든 게시글 가지고 왔습니다.");
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id + "번 글을 읽어옵니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성했습니다.");
		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public boolean removeBoard(int id) {
		System.out.println("게시글 삭제합니다.");
		int result = boardDao.deleteBoard(id);
		System.out.println(result);

//		if(result == 1) return true;
//		return false;
		return result == 1;
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글을 수정합니다.");

		// 실제로 우리 수정하고 싶은 id를 가진 게시글을 일단 가지고와서.
//		Board tmp = boardDao.selectOne(board.getId());
//		tmp.setTitle(board.getTitle());
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		return boardDao.search(condition);
	}

	@Override
	public void fileUpload(MultipartFile file, Board board) {
		if (file != null && file.getSize() > 0) {
			try {
				String fileName = file.getOriginalFilename(); // 실제파일 이름
				// 확장자를 따로 저장하는 그러한 처리가 사실은 필요하다.
				String fileId = UUID.randomUUID().toString(); // 고유한 이름(확장자 날아가요)
				// 게시글 바구니를 확장 시켜서 파일 정보도 저장을 해보자아~~
				board.setFileId(fileId+"jpg");
				board.setFileName(fileName);

				// 어디다가 저장을 할래잉.
				Resource resource = resourceLoader.getResource("classpath:/static/img");
				file.transferTo(new File(resource.getFile(), fileId));
				//////////////////////////////위의 코드까지 정상 수행이 되면... 
				boardDao.insertBoard(board);
				boardDao.insertFile(board);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
