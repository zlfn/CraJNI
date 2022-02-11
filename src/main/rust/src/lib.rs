#![crate_type="cdylib"]
#![allow(non_camel_case_types)]
#![allow(non_snake_case)]
#![allow(unused_variables)]

use std::alloc::alloc;
use std::collections::HashSet;
use std::ffi::{c_void, CString};
use jni::objects::{JClass, JString};
use jni::JNIEnv;
use jni::sys::{jboolean, jlong, JNI_TRUE, jstring};
use primes::{factors, factors_uniq, PrimeSet};

#[no_mangle]
pub extern fn Java_com_iroom_crajni_Native_getPrimeFactorsRust(jre: JNIEnv, class: c_void, num: jlong) -> JString
{
    let mut rnum = num as i64;

    let mut setPrimeFactors: HashSet<i64> = HashSet::new();
    let mut i= 2;
    while i<=rnum {
        if rnum % i == 0
        {
            setPrimeFactors.insert(i);
            rnum /= i;
            i -= 1;
        }
        i += 1;
    }
    let x = format!("{:?}",setPrimeFactors);

    return jre.new_string(x).unwrap();
}

#[no_mangle]
pub extern fn Java_com_iroom_crajni_Native_getPrimeFactorsRustDouble(jre: JNIEnv, class: c_void, num: jlong) -> JString
{
    let mut rnum = num.clone() as i64;

    let mut setPrimeFactors: HashSet<i64> = HashSet::new();
    let mut i= 2;
    while i<=rnum {
        if rnum % i == 0
        {
            setPrimeFactors.insert(i);
            rnum /= i;
            i -= 1;
        }
        i += 1;
    }

    let mut rnum = num as i64;

    let mut setPrimeFactors: HashSet<i64> = HashSet::new();
    let mut i= 2;
    while i<=rnum {
        if rnum % i == 0
        {
            setPrimeFactors.insert(i);
            rnum /= i;
            i -= 1;
        }
        i += 1;
    }

    let x = format!("{:?}",setPrimeFactors);

    return jre.new_string(x).unwrap();
}

#[no_mangle]
pub extern fn Java_com_iroom_crajni_Native_getPrimeFactorsRustLib(jre:JNIEnv, class: c_void, num: jlong) -> JString
{
    let mut rnum = num as i64;
    let x = format!("{:?}",factors_uniq(rnum as u64));

    return jre.new_string(x).unwrap();
}

#[no_mangle]
pub extern fn Java_com_iroom_crajni_Native_recall(jre:JNIEnv,class: c_void, num:jlong) -> JString
{
    let mut rnum = num as i64;
    return jre.new_string(rnum.to_string()).unwrap()
}