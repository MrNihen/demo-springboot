# demo-springboot

**学生管理**


**简介**：<p>学生管理swagger RESTful APIs......</p>


**HOST**:localhost:9000

**联系人**:泥痕留痕

**Version**:1.0

**接口路径**：/v2/api-docs


# classes-controller

## 添加班级


**接口描述**:


**接口地址**:`/classes/add`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"cid": 0,
	"cname": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|classesDTO| classesDTO  | body | true |ClassesDTO  | ClassesDTO   |

**schema属性说明**



**ClassesDTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|cid| 班级编号  | body | false |integer(int64)  |    |
|cname| 班级名称  | body | false |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据id删除班级信息


**接口描述**:


**接口地址**:`/classes/delectClasses`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|ids| ids  | query | true |array  | integer   |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 查询所有班级


**接口描述**:


**接口地址**:`/classes/findAll`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 分页查询所有班级


**接口描述**:


**接口地址**:`/classes/findByPage`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|pageNo| pageNo  | query | true |integer  |    |
|pageSize| pageSize  | query | true |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据id查找一个班级信息


**接口描述**:


**接口地址**:`/classes/findOne`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|cid| cid  | query | true |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 模糊查询带分页


**接口描述**:


**接口地址**:`/classes/searchByPage`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"cid": 0,
	"cname": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|classesDTO| classesDTO  | body | true |ClassesDTO  | ClassesDTO   |
|pageNo| pageNo  | query | true |integer  |    |
|pageSize| pageSize  | query | true |integer  |    |

**schema属性说明**



**ClassesDTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|cid| 班级编号  | body | false |integer(int64)  |    |
|cname| 班级名称  | body | false |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据id修改班级信息


**接口描述**:


**接口地址**:`/classes/updateClasses`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"cid": 0,
	"cname": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|classesDTO| classesDTO  | body | true |ClassesDTO  | ClassesDTO   |

**schema属性说明**



**ClassesDTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|cid| 班级编号  | body | false |integer(int64)  |    |
|cname| 班级名称  | body | false |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# student-controller

## 添加学生


**接口描述**:


**接口地址**:`/student/addStudent`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"addr": "",
	"age": 0,
	"cname": "",
	"sex": "",
	"sid": 0,
	"sname": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|studentDTO| studentDTO  | body | true |StudentDTO  | StudentDTO   |

**schema属性说明**



**StudentDTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|addr| 学生地址  | body | false |string  |    |
|age| 学生年龄  | body | false |integer(int32)  |    |
|cname| 学生所在班级  | body | false |string  |    |
|sex| 学生性别  | body | false |string  |    |
|sid| 学生编号  | body | false |integer(int64)  |    |
|sname| 学生姓名  | body | false |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 根据id删除学生信息


**接口描述**:


**接口地址**:`/student/deleteStudent`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|ids| ids  | query | true |array  | integer   |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 搜索分页学生信息


**接口描述**:


**接口地址**:`/student/searchStudentByPage`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"addr": "",
	"age": 0,
	"cname": "",
	"sex": "",
	"sid": 0,
	"sname": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|pageNo| pageNo  | query | true |integer  |    |
|pageSize| pageSize  | query | true |integer  |    |
|studentDTO| studentDTO  | body | true |StudentDTO  | StudentDTO   |

**schema属性说明**



**StudentDTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|addr| 学生地址  | body | false |string  |    |
|age| 学生年龄  | body | false |integer(int32)  |    |
|cname| 学生所在班级  | body | false |string  |    |
|sex| 学生性别  | body | false |string  |    |
|sid| 学生编号  | body | false |integer(int64)  |    |
|sname| 学生姓名  | body | false |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 分页列表学生


**接口描述**:


**接口地址**:`/student/selectStudentByPage`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|pageNo| pageNo  | query | true |integer  |    |
|pageSize| pageSize  | query | true |integer  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 查询学生列表


**接口描述**:


**接口地址**:`/student/studentList`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：
暂无



**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 修改学生信息


**接口描述**:


**接口地址**:`/student/updateStudent`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"addr": "",
	"age": 0,
	"cname": "",
	"sex": "",
	"sid": 0,
	"sname": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|studentDTO| studentDTO  | body | true |StudentDTO  | StudentDTO   |

**schema属性说明**



**StudentDTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|addr| 学生地址  | body | false |string  |    |
|age| 学生年龄  | body | false |integer(int32)  |    |
|cname| 学生所在班级  | body | false |string  |    |
|sex| 学生性别  | body | false |string  |    |
|sid| 学生编号  | body | false |integer(int64)  |    |
|sname| 学生姓名  | body | false |string  |    |

**响应示例**:

```json
{
	"code": 0,
	"data": {},
	"flag": true,
	"message": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|code|   |integer(int32)  | integer(int32)   |
|data|   |object  |    |
|flag|   |boolean  |    |
|message|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |Result|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
