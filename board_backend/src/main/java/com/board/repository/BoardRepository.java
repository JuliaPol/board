package com.board.repository;

import com.board.model.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    Board findBoardByNameAndUsersLogin(String name, String login);
}
