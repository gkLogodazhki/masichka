package com.websystique.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.IReservationDao;
import com.websystique.springmvc.model.Reservation;


@Service("reservationService")
@Transactional
public class ReservationService implements IReservationDao{
	
	@Autowired
    private IReservationDao reservationDao;

	@Override
	public void save(Reservation reservation) {
		reservationDao.save(reservation);
	}
	
}
