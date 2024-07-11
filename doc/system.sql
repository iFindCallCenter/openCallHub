create table sys_menu
(
    menu_id     bigint auto_increment comment '菜单ID'  primary key,
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
    user_id      bigint auto_increment comment '用户ID'
        primary key,
    user_name    varchar(50)                        not null comment '用户账号',
    nick_name    varchar(50)                        null comment '用户昵称',
    password     varchar(64)                        null comment '密码',
    avatar       varchar(128)                       null comment '用户头像',
    sex          tinyint                            null comment '用户性别（0-未知 1-男 2-女）',
    phone        varchar(32)                        null comment '手机号',
    email        varchar(32)                        null comment '邮箱',
    status       tinyint  default 1                 null comment '状态 1-启用 2-禁用',
    remark       varchar(500)                       null comment '备注',
    create_by    bigint   default 1                 null comment '创建人',
    create_time  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_by    bigint                             null comment '更新人',
    update_time  datetime                           null comment '更新时间',
    del_flag     tinyint  default 0                 not null comment '删除标识 0 正常 1 删除'
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


