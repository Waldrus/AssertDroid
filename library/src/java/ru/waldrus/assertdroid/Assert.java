package ru.waldrus.assertdroid;

import java.util.Objects;

/**
 * Created by Wald on 11.04.2014.
 */
public class Assert {
    /* package */ static final int HANDLE_DEBUG = 0x1;
    /* package */ static final int HANDLE_NORMAL = 0x2;
    /* package */ static Handler HANDLER;
    /* package */ static boolean DEBUG;
    /* package */ static int HANDLE_LEVEL = HANDLE_NORMAL;

    protected Assert() {   }

    public static void fail(String message) {
        if (DEBUG || (null != HANDLER && (HANDLE_LEVEL & HANDLE_NORMAL) > 0)){
            AssertDroidError ae = new AssertDroidError(message);

            if (null != HANDLER && ((HANDLE_LEVEL & HANDLE_NORMAL) > 0 || (HANDLE_LEVEL & HANDLE_DEBUG) > 0)){
                HANDLER.onHandle(ae);
            }

            if (DEBUG){
                throw ae;
            }
        }
    }

    public static void fail() {
        if (DEBUG || (null != HANDLER && (HANDLE_LEVEL & HANDLE_NORMAL) > 0)){
            AssertDroidError ae = new AssertDroidError();

            if (null != HANDLER && ((HANDLE_LEVEL & HANDLE_NORMAL) > 0 || (HANDLE_LEVEL & HANDLE_DEBUG) > 0)){
                HANDLER.onHandle(ae);
            }

            if (DEBUG){
                throw ae;
            }
        }
    }


    public static void assertTrue(String message, boolean condition) {
        if (!condition){
            fail(message);
        }
    }

    public static void assertTrue(boolean condition) {
        if (!condition){
            fail();
        }
    }

    public static void assertFalse(String message, boolean condition) {
        if (condition){
            fail(message);
        }
    }

    public static void assertFalse(boolean condition) {
        if (condition){
            fail();
        }
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        failNotEquals(message, expected, actual);
    }

    public static void assertEquals(Object expected, Object actual) {
        failNotEquals(null, expected, actual);
    }

    public static void assertEquals(String message, String expected, String actual) {
        failNotEquals(message, expected, actual);
    }

    public static void assertEquals(String expected, String actual) {
        assertEquals((Object) expected, (Object) actual);
    }

    public static void assertEquals(String message, double expected, double actual, double delta) {
        if (actual < expected - delta  || expected + delta < actual){
            fail(message);
        }
    }

    public static void assertEquals(double expected, double actual, double delta) {
        if (actual < expected - delta  || expected + delta < actual){
            fail();
        }
    }

    public static void assertEquals(String message, float expected, float actual, float delta) {
        if (actual < expected - delta  || expected + delta < actual){
            fail(message);
        }
    }

    public static void assertEquals(float expected, float actual, float delta) {
        if (actual < expected - delta  || expected + delta < actual){
            fail();
        }
    }

    public static void assertEquals(String message, long expected, long actual) {
        if (actual != expected){
            fail(message);
        }
    }

    public static void assertEquals(long expected, long actual) {
        if (actual != expected){
            fail();
        }
    }

    public static void assertEquals(String message, boolean expected, boolean actual) {
        if (actual != expected){
            fail(message);
        }
    }

    public static void assertEquals(boolean expected, boolean actual) {
        if (actual != expected){
            fail();
        }
    }

    public static void assertEquals(String message, byte expected, byte actual) {
        if (actual != expected){
            fail(message);
        }
    }

    public static void assertEquals(byte expected, byte actual) {
        if (actual != expected){
            fail();
        }
    }

    public static void assertEquals(String message, char expected, char actual) {
        if (actual != expected){
            fail(message);
        }
    }

    public static void assertEquals(char expected, char actual) {
        if (actual != expected){
            fail();
        }
    }

    public static void assertEquals(String message, short expected, short actual) {
        if (actual != expected){
            fail(message);
        }
    }

    public static void assertEquals(short expected, short actual) {
        if (actual != expected){
            fail();
        }
    }

    public static void assertEquals(String message, int expected, int actual) {
        if (actual != expected){
            fail(message);
        }
    }

    public static void assertEquals(int expected, int actual) {
        if (actual != expected){
            fail();
        }
    }

    public static void assertNotNull(Object object) {
        if (null == object){
            fail();
        }
    }

    public static void assertNotNull(String message, Object object) {
        if (null == object){
            fail(message);
        }
    }

    public static void assertNull(Object object) {
        failNotEquals(null, null, object);
    }

    public static void assertNull(String message, Object object) {
        failNotEquals(message, null, object);
    }

    public static void assertSame(String message, Object expected, Object actual) {
        if (expected != actual){
            fail(message);
        }
    }

    public static void assertSame(Object expected, Object actual) {
        if (expected != actual){
            fail();
        }
    }

    public static void assertNotSame(String message, Object expected, Object actual) {
        if (expected == actual){
            fail(message);
        }
    }

    public static void assertNotSame(Object expected, Object actual) {
        if (expected == actual){
            fail();
        }
    }

    public static void failSame(String message) {
        fail(message);
    }

    public static void failNotSame(String message, Object expected, Object actual) {
        if (expected == actual) {
            fail(message);
        }
    }

    public static void failNotEquals(String message, Object expected, Object actual) {
        if (null != expected){
            if (!expected.equals(actual)){
                fail(message);
            }
        } else {
            if (null != actual){
                fail(message);
            }
        }
    }

    public static String format(String message, Object expected, Object actual) { 
        return null;
    }
}
