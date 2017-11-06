package com.websystique.springmvc.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Reservation;

@Repository("reservationDao")
@Transactional
public class ReservationDao extends AbstractDao<Integer, Reservation> implements IReservationDao{

	@Override
	public void save(Reservation reservation) {
	     persist(reservation);
	}

}
