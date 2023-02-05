package com.pushpraj.springcloud.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pushpraj.springcloud.model.Coupon;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
