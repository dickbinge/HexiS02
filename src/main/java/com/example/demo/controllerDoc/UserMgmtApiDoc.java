package com.example.demo.controllerDoc;



/**
 * @api {post} /user/add AddUser
 * @apiVersion 1.0.0
 * @apiName AddUser
 * @apiGroup UserMgmt
 * @apiParamExample {json} Request-Body Example:
 * {
 *    "name": "Jingbin",
 *    "password": "111111",
 *    "sno": "03121333",
 *    "email":"1150239561@qq.com"
 * }
 * @apiParam {String} name the user name
 * @apiParam {String} password the user password
 * @apiParam {String} sno the user sno
 * @apiParam {String} email the user email
 * @apiExample {Text} Request-Example:
 *   http://localhost:8080/api/v1.0/user/add
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
 *   {
 *       "result": true
 *   }
 */

/**
 * @api {put} /user/edit EditUser
 * @apiVersion 1.0.0
 * @apiName EditUser
 * @apiGroup UserMgmt
 *
 * @apiParamExample {json} Request-Body Example:
 * {
 *    "name": "Jingbin",
 *    "password": "111111",
 *    "sno": "03121333",
 *    "email":"1150239561@qq.com"
 * }
 * @apiParam {String} name the user name
 * @apiParam {String} password the user password
 * @apiParam {String} sno the user sno
 * @apiParam {String} email the user email
 *
 * @apiExample {Text} Request-Example:
 *   http://localhost:8080/api/v1.0/user/edit

 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
 *   {
 *       "result": true
 *   }
 */


/**
 * @api {delete} /user/delete DeleteUser
 * @apiVersion 1.0.0
 * @apiName DeleteUser
 * @apiGroup UserMgmt
 *
 * @apiParam {Integer} userId the userId
 *
 *  @apiExample {Text} Request-Example:
 *   http://localhost:8080/api/v1.0/user/delete?userId=1

 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
 *   {
 *       "result": true
 *   }
 */
