package cn.ch.netem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ch.netem.mapper.SubjectMapper;
import cn.ch.netem.pojo.Subject;
import cn.ch.netem.service.SubjectService;
@Transactional
@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public List<Subject> getSubjectList() {
		// TODO Auto-generated method stub
		return subjectMapper.selectByExample();
	}

}
