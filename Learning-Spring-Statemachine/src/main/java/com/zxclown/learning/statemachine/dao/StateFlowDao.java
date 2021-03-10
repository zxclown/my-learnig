package com.zxclown.learning.statemachine.dao;

import com.zxclown.learning.statemachine.bean.StateFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface State flow dao.
 * @author za-zhangxin002
 */
@Repository
public interface StateFlowDao extends JpaRepository<StateFlow, Long> {
}
