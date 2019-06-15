package com.multi.cekl.utils;

import com.multi.cekl.response.CustomResponse;

public class ResponseMessage {
    public static CustomResponse success = new CustomResponse("201", "record deleted successfully!");
    public static CustomResponse failed = new CustomResponse("200", "record was not deleted!");
    public static CustomResponse notfound = new CustomResponse("404", "record not found!");
}
