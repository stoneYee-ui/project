package com.shopping.project.member;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends CrudRepository<Member, String>{
	public abstract List<Member> findAll();
}
