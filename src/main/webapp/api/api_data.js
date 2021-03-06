define({ "api": [
  {
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "optional": false,
            "field": "varname1",
            "description": "<p>No type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "varname2",
            "description": "<p>With type.</p>"
          }
        ]
      }
    },
    "type": "",
    "url": "",
    "version": "0.0.0",
    "filename": "./src/main/webapp/api/main.js",
    "group": "L__HexiS02_src_main_webapp_api_main_js",
    "groupTitle": "L__HexiS02_src_main_webapp_api_main_js",
    "name": ""
  },
  {
    "type": "post",
    "url": "/user/add",
    "title": "AddUser",
    "version": "1.0.0",
    "name": "AddUser",
    "group": "UserMgmt",
    "parameter": {
      "examples": [
        {
          "title": "Request-Body Example:",
          "content": "{\n   \"name\": \"Jingbin\",\n   \"password\": \"111111\",\n   \"sno\": \"03121333\",\n   \"email\":\"1150239561@qq.com\"\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>the user name</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>the user password</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sno",
            "description": "<p>the user sno</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>the user email</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "http://localhost:8080/api/v1.0/user/add",
        "type": "Text"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n    \"result\": true\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./src/main/java/com/example/demo/controllerDoc/UserMgmtApiDoc.java",
    "groupTitle": "UserMgmt"
  },
  {
    "type": "delete",
    "url": "/user/delete",
    "title": "DeleteUser",
    "version": "1.0.0",
    "name": "DeleteUser",
    "group": "UserMgmt",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "userId",
            "description": "<p>the userId</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "http://localhost:8080/api/v1.0/user/delete?userId=1",
        "type": "Text"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n    \"result\": true\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./src/main/java/com/example/demo/controllerDoc/UserMgmtApiDoc.java",
    "groupTitle": "UserMgmt"
  },
  {
    "type": "put",
    "url": "/user/edit",
    "title": "EditUser",
    "version": "1.0.0",
    "name": "EditUser",
    "group": "UserMgmt",
    "parameter": {
      "examples": [
        {
          "title": "Request-Body Example:",
          "content": "{\n   \"name\": \"Jingbin\",\n   \"password\": \"111111\",\n   \"sno\": \"03121333\",\n   \"email\":\"1150239561@qq.com\"\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>the user name</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>the user password</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sno",
            "description": "<p>the user sno</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>the user email</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "http://localhost:8080/api/v1.0/user/edit",
        "type": "Text"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n    \"result\": true\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./src/main/java/com/example/demo/controllerDoc/UserMgmtApiDoc.java",
    "groupTitle": "UserMgmt"
  }
] });
