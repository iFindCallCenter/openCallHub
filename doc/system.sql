create table sys_menu
(
    menu_id     bigint auto_increment comment '菜单ID' primary key,
    menu_name   varchar(50)                            not null comment '菜单名称',
    parent_id   bigint       default 0                 null comment '父菜单ID',
    order_num   int          default 0                 null comment '显示顺序',
    path        varchar(200) default ''                null comment '路由地址',
    component   varchar(255)                           null comment '组件路径',
    is_frame    tinyint      default 1                 null comment '是否为外链（0是 1否）',
    menu_type   char         default ''                null comment '菜单类型（M目录 C菜单 F按钮）',
    visible     tinyint      default 0                 null comment '菜单状态（0显示 1隐藏）',
    status      tinyint      default 0                 null comment '菜单状态（0正常 1停用）',
    perms       varchar(100)                           null comment '权限标识',
    icon        varchar(100) default '#'               null comment '菜单图标',
    remark      varchar(500) default ''                null comment '备注',
    create_by   bigint                                 null comment '创建人',
    create_time datetime     default CURRENT_TIMESTAMP null comment '创建时间',
    update_by   bigint                                 null comment '更新人',
    update_time datetime                               null comment '更新时间',
    del_flag    tinyint      default 0                 not null comment '删除标识 0 正常 1 删除'
)
    comment '菜单权限表';

create table sys_oper_log
(
    id             bigint auto_increment comment '日志主键'
        primary key,
    title          varchar(50)   default ''                null comment '模块标题',
    business_type  tinyint       default 0                 null comment '业务类型（0=其它,1=新增,2=修改,3=删除,4=查询,5=导出,6=导入 7-登录 8-登出）',
    method         varchar(100)  default ''                null comment '方法名称',
    request_method varchar(10)   default ''                null comment '请求方式',
    operator_type  tinyint       default 0                 null comment '操作类别（0其它 1后台用户 2手机端用户）',
    oper_name      varchar(50)   default ''                null comment '操作人员',
    oper_url       varchar(255)  default ''                null comment '请求URL',
    oper_ip        varchar(128)  default ''                null comment '主机地址',
    oper_location  varchar(255)  default ''                null comment '操作地点',
    oper_param     varchar(2000) default ''                null comment '请求参数',
    json_result    varchar(2000) default ''                null comment '返回参数',
    status         tinyint       default 0                 null comment '操作状态（0正常 1异常）',
    error_msg      varchar(2000) default ''                null comment '错误消息',
    oper_time      datetime                                null comment '操作时间',
    cost_time      bigint        default 0                 null comment '消耗时间',
    create_by      varchar(255)                            null comment '创建人',
    create_time    datetime      default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by      varchar(255)                            null comment '更新人',
    update_time    datetime                                null comment '修改时间',
    del_flag       tinyint       default 0                 not null comment '删除标识 0正常 1 删除'
)
    comment '系统操作日志记录';

create index idx_sys_oper_log_bt
    on sys_oper_log (business_type);

create index idx_sys_oper_log_ot
    on sys_oper_log (oper_time);

create index idx_sys_oper_log_s
    on sys_oper_log (status);

create table sys_role
(
    role_id     bigint auto_increment comment '角色ID'
        primary key,
    role_name   varchar(30)                        not null comment '角色名称',
    role_key    varchar(100)                       not null comment '角色权限字符串',
    role_sort   int                                not null comment '显示顺序',
    data_scope  tinyint  default 1                 null comment '数据范围（1：全部数据权限 2:本部门及以下数据权限 3：本部门数据权限 4：本人数据权限）',
    status      tinyint  default 0                 null comment '角色状态（0正常 1停用）',
    remark      varchar(500)                       null comment '备注',
    create_by   bigint                             null comment '创建人',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by   bigint                             null comment '更新人',
    update_time datetime                           null comment '更新时间',
    del_flag    tinyint  default 0                 not null comment '删除标识 0 正常 1 删除'
)
    comment '角色信息表';

create table sys_role_menu
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    role_id     bigint                             not null comment '角色ID',
    menu_id     bigint                             not null comment '菜单ID',
    create_by   bigint                             null comment '创建人',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by   bigint                             null comment '更新人',
    update_time datetime                           null comment '更新时间',
    del_flag    tinyint  default 0                 not null comment '删除标识 0 正常 1 删除'
)
    comment '角色菜单关联表';

create index role_menu_id_idx
    on sys_role_menu (menu_id, role_id);

create table sys_user
(
    user_id     bigint auto_increment comment '用户ID'
        primary key,
    user_name   varchar(50)                        not null comment '用户账号',
    nick_name   varchar(50)                        null comment '用户昵称',
    password    varchar(64)                        null comment '密码',
    avatar      varchar(128)                       null comment '用户头像',
    sex         tinyint                            null comment '用户性别（0-未知 1-男 2-女）',
    phone       varchar(32)                        null comment '手机号',
    email       varchar(32)                        null comment '邮箱',
    status      tinyint  default 1                 null comment '状态 1-启用 2-禁用',
    remark      varchar(500)                       null comment '备注',
    create_by   bigint   default 1                 null comment '创建人',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by   bigint                             null comment '更新人',
    update_time datetime                           null comment '更新时间',
    del_flag    tinyint  default 0                 not null comment '删除标识 0 正常 1 删除'
)
    comment '用户信息表';

create table sys_user_role
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    user_id     bigint                             not null comment '用户ID',
    role_id     bigint                             not null comment '角色ID',
    create_by   bigint                             null comment '创建人',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by   bigint                             null comment '更新人',
    update_time datetime                           null comment '更新时间',
    del_flag    tinyint  default 0                 not null comment '删除标识 0 正常 1 删除'
)
    comment '用户角色关联表';

create index user_role_id_idx
    on sys_user_role (user_id, role_id);



create table fs_acl
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    name         varchar(50)                 not null comment '名称',
    default_type varchar(20) default 'allow' null comment '类型 allow-允许 deny-拒绝',
    list_id      bigint      default 0       not null comment '列表ID',
    node_type    varchar(20)                 null comment '规则类型 allow-允许 deny-拒绝',
    cidr         varchar(64)                 null comment 'IP地址',
    domain       varchar(64)                 null comment '域地址',
    create_by    bigint                      null comment '创建人',
    create_time  datetime                    null comment '创建时间',
    update_by    bigint                      null comment '更新人',
    update_time  datetime                    null comment '更新时间',
    del_flag     tinyint     default 0       not null comment '删除标识 0 正常 1 删除'
)
    comment 'fs访问控制表';

create table fs_dialplan
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    group_id     bigint            not null comment '分组ID',
    name         varchar(128)      not null comment '计划名称',
    type         varchar(64)       not null comment '类型 xml格式,json格式',
    expression   varchar(100)      null comment '正则匹配规则',
    context_name varchar(32)       not null comment '内容类型 public、default',
    content      longtext          not null comment '内容',
    `describe`   varchar(256)      not null comment '描述',
    create_by    bigint            null comment '创建人',
    create_time  datetime          null comment '创建时间',
    update_by    bigint            null comment '更新人',
    update_time  datetime          null comment '更新时间',
    del_flag     tinyint default 0 not null comment '删除标识 0 正常 1 删除'
)
    comment 'fs拨号计划表';

create table fs_config
(
    id          int auto_increment comment '主键ID'
        primary key,
    name        varchar(128)                       null comment '名称',
    `group`     varchar(64)                        null comment '客户端分组',
    ip          varchar(64)                        null comment '机器地址IP',
    port        int                                null comment '服务器端口',
    user_name   varchar(64)                        null comment '用户名',
    password    varchar(64)                        null comment '密码',
    status      tinyint  default 0                 null comment '状态 0-在线 1-下线',
    out_time    int                                null comment '超时时间（秒）',
    create_by   bigint                             null comment '创建人',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   bigint                             null comment '更新人',
    update_time datetime                           null comment '修改时间',
    del_flag    tinyint  default 0                 not null comment '删除标识 0 有效 1删除'
)
    comment 'fs管理配置表';


create table fs_cdr
(
    call_id                bigint                             not null comment '通话唯一ID'
        primary key,
    uuid                   varchar(64)                        null comment 'uuid',
    direction              varchar(16)                        null comment '呼叫方向 outbound-呼出 inbound-呼入',
    sip_local_network_addr varchar(32)                        null comment '本地呼叫地址',
    sip_network_ip         varchar(32)                        null comment '呼叫IP',
    caller_id_number       varchar(64)                        null comment '主叫号码',
    caller_display         varchar(64)                        null comment '主叫显号',
    destination_number     varchar(64)                        null comment '被叫号码',
    destination_display    varchar(64)                        null comment '被叫显号',
    start_stamp            datetime                           null comment '开始时间',
    answer_stamp           datetime                           null comment '应答时间',
    end_stamp              datetime                           null comment '结束时间',
    bridge_stamp           datetime                           null comment '桥接时间',
    progress_stamp         datetime                           null comment '振铃时间',
    duration               int                                null comment '呼叫时长',
    answer_sec             int                                null comment '应答时长',
    bill_sec               int                                null comment '计费时长',
    hangup_cause           varchar(64)                        null comment '挂断原因',
    record_start_time      datetime                           null comment '录音开始时间',
    record_end_time        datetime                           null comment '录音结束时间',
    record_sec             int                                null comment '录音时长',
    record                 varchar(128)                       null comment '录音地址',
    read_codec             varchar(64)                        null comment '读编码类型',
    write_codec            varchar(64)                        null comment '写编码类型',
    sip_hangup_disposition varchar(64)                        null comment '挂断意向',
    create_by              bigint                             null comment '创建人',
    create_time            datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by              bigint                             null comment '更新人',
    update_time            datetime                           null comment '修改时间',
    del_flag               tinyint  default 0                 not null comment '删除标识 0 有效 1删除'
)
    comment 'cdr话单表';

create table fs_modules
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    fs_name     varchar(128)      not null comment 'FS主机名',
    name        varchar(128)      not null comment '模块名称',
    type        varchar(64)       not null comment '类型 xml格式,json格式',
    content     longtext          not null comment '内容',
    `describe`  varchar(256)      not null comment '描述',
    create_by   bigint            null comment '创建人',
    create_time datetime          null comment '创建时间',
    update_by   bigint            null comment '更新人',
    update_time datetime          null comment '更新时间',
    del_flag    tinyint default 0 not null comment '删除标识 0 正常 1 删除'
)
    comment 'fs模块管理表';

create table fs_sip_gateway
(
    id                bigint auto_increment comment '主键ID'
        primary key,
    name              varchar(50)                           not null comment '网关名称',
    uer_name          varchar(50)                           null comment '账号',
    password          varchar(64)                           null comment '密码',
    realm             varchar(32)                           not null comment '认证地址',
    proxy             varchar(32)                           null comment '代理地址',
    register          tinyint     default 1                 null comment '注册类型 0-不注册 1-注册',
    transport         tinyint     default 1                 null comment '注册协议 1-udp, 2-tcp',
    caller_id_in_from tinyint     default 0                 not null comment '通过此网关出站呼叫时，在from字段中使用入站呼叫的callerid(0-true 1-false)',
    from_domain       varchar(32) default ''                null comment 'from域',
    retry_time        int         default 30                null comment '重试时间（秒）',
    ping_time         int         default 30                null comment '心跳时间（秒）',
    expire_time       int         default 300               not null comment '超时时间（秒）',
    create_by         bigint                                null comment '创建人',
    create_time       datetime    default CURRENT_TIMESTAMP null comment '创建时间',
    update_by         bigint                                null comment '更新人',
    update_time       datetime                              null comment '更新时间',
    del_flag          tinyint     default 0                 not null comment '删除标识 0 正常 1 删除'
)
    comment 'SIP网关表';


create table sys_category
(
    id          bigint                                not null comment '主键id'
        primary key,
    type        int                                   not null comment '1-技能 ',
    name        varchar(50)                           null comment '分类名称',
    parent_id   bigint(100) default 0                 null comment '父分类的id',
    flag        tinyint     default 0                 null comment '可删除标识 0 可删除 1 不可删除',
    create_by   bigint                                null comment '创建人',
    create_time datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by   bigint                                null comment '更新人',
    update_time datetime                              null comment '修改时间',
    del_flag    tinyint     default 0                 not null comment '删除标识 0 有效 1删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '分类配置表';


CREATE TABLE `dispatcher`
(
    `id`          int(10)      NOT NULL AUTO_INCREMENT,
    `setid`       int(11)      NOT NULL DEFAULT '0' COMMENT '分组ID',
    `destination` varchar(192) NOT NULL DEFAULT '' COMMENT '目标地址',
    `flags`       int(11)      NOT NULL DEFAULT '0' COMMENT '标识',
    `priority`    int(11)      NOT NULL DEFAULT '0' COMMENT '优先级',
    `attrs`       varchar(128) NOT NULL DEFAULT '' COMMENT '属性',
    `description` varchar(64)  NOT NULL DEFAULT '' COMMENT '描述',
    `status`      tinyint(4)            DEFAULT '0' COMMENT '状态 0-在线 1-下线',
    `create_by`   bigint(20)            DEFAULT NULL COMMENT '创建人',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   bigint(20)            DEFAULT NULL COMMENT '更新人',
    `update_time` datetime              DEFAULT NULL COMMENT '更新时间',
    `del_flag`    tinyint(4)   NOT NULL DEFAULT '0' COMMENT '删除标识 0 正常 1 删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment 'KO负载管理表';


CREATE TABLE `subscriber`
(
    `id`       int(10)      NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `username` varchar(64)  NOT NULL DEFAULT '' COMMENT '用户名称',
    `domain`   varchar(64)  NOT NULL DEFAULT '' COMMENT '域名地址',
    `password` varchar(64)  NOT NULL DEFAULT '' COMMENT '密码',
    `ha1`      varchar(128) NOT NULL DEFAULT '' COMMENT '哈希码',
    `ha1b`     varchar(128) NOT NULL DEFAULT '' COMMENT '哈希码',
    `vmpin`    varchar(8)   NOT NULL DEFAULT '1234' COMMENT '鉴权值',
    PRIMARY KEY (`id`),
    UNIQUE KEY `account_idx` (`username`, `domain`),
    KEY `username_idx` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '用户订阅表（SIP 订阅）';


create table sip_agent
(
    id            bigint auto_increment comment '主键ID'
        primary key,
    name          varchar(128)      not null comment '坐席名称',
    user_id       bigint            not null comment '主键ID',
    agent_number  varchar(64)       not null comment 'sip账号ID',
    status        tinyint default 0 not null comment '开通状态 0-未开通 1-开通',
    online_status tinyint default 3 not null comment '在线状态 0-空闲  1-忙碌 2-通话中 3-离线',
    create_by     bigint            null comment '创建人',
    create_time   datetime          null comment '创建时间',
    update_by     bigint            null comment '更新人',
    update_time   datetime          null comment '更新时间',
    del_flag      tinyint default 0 not null comment '删除标识 0 正常 1 删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '坐席管理表';


create table corp_info
(
    id                int(20) auto_increment comment '主键ID'
        primary key,
    corp_name         varchar(50)                            not null comment '企业名称',
    corp_code         varchar(64)                            null comment '企业编码',
    secret_key        varchar(32)                            not null comment '密钥',
    status            tinyint      default 1                 null comment '企业状态 1-启用 2-禁用',
    seat_num          int          default 0                 null comment '坐席数量',
    ivr_num           int          default 0                 null comment 'IVR并发数量',
    record_num        int          default 0                 null comment '录音保留天数',
    balance           varchar(18)  default '0'               null comment '账户余额',
    corp_manage       varchar(50)                            null comment '企业负责人',
    corp_manage_phone varchar(32)  default ''                null comment '企业负责人手机号',
    call_back_path    varchar(200) default ''                null comment '回调地址',
    remark            varchar(500) default ''                null comment '备注',
    create_by         bigint                                 null comment '创建人',
    create_time       datetime     default CURRENT_TIMESTAMP null comment '创建时间',
    update_by         bigint                                 null comment '更新人',
    update_time       datetime                               null comment '更新时间',
    del_flag          tinyint      default 0                 not null comment '删除标识 0 正常 1 删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '企业信息表';


create table call_route
(
    id                 bigint auto_increment
        primary key,
    route_num          varchar(32)                           not null comment '路由号码',
    caller_num         varchar(32) default '*'               not null comment '主叫号码',
    len_min            int         default 4                 null comment '号码匹配最小长度',
    len_max            int         default 32                null comment '号码匹配最大长度',
    caller_pattern     varchar(64)                           null comment '主叫替换规则',
    caller_replace_num varchar(32)                           null comment '主叫替换号码',
    callee_pattern     varchar(64)                           null comment '被叫替换规则',
    callee_replace_num varchar(32)                           null comment '被叫替换号码',
    status             tinyint     default 0                 null comment '状态  0-未启用 1-启用',
    create_by          bigint                                null comment '创建人',
    create_time        datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by          bigint                                null comment '更新人',
    update_time        datetime                              null comment '修改时间',
    del_flag           tinyint     default 0                 not null comment '删除标识 0 有效 1删除'
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 comment '号码路由表';


create table call_display
(
    id          bigint auto_increment comment '主键'
        primary key,
    phone       varchar(18)                        not null comment '电话号码',
    type        tinyint  default 1                 not null comment '号码类型 1-主叫显号 2-被叫显号',
    area        varchar(64)                        null comment '归属地',
    create_by   bigint                             null comment '创建人',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by   bigint                             null comment '更新人',
    update_time datetime                           null comment '更新时间',
    del_flag    tinyint  default 0                 not null comment '删除标识 0 正常 1 删除'
)
    comment '显号管理';






