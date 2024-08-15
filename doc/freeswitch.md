## CentOS系统 Freeswitch 安装
1. #### 下载安装包  
``` shell
sudo yum install epel-release vim tcpdump net-tools.x86_64 -y  
sudo yum install gcc-c++ sqlite-devel zlib-devel libcurl-devel pcre-devel speex-devel ldns-devel libedit-devel openssl-devel git -y  
sudo yum install yasm nasm opus-devel -y  
sudo yum groupinstall perl* -y  
sudo yum install python -y  
sudo yum install bzip2 -y  
sudo yum install -y libshout-devel lame-devel libmpg123-devel  
sudo yum install bc -y  
sudo yum install curl -y  
sudo yum install expect telnet -y  
sudo yum install -y unixODBC unixODBC-devel mysql-connector-odbc  
sudo yum install -y yum-plugin-ovl centos-release-scl rpmdevtools yum-utils git wget vim devtoolset-7-gcc* devtoolset-7 libtiff-devel cmake3 libatomic unixODBC unixODBC-devel.x86_64 postgresql-libs postgresql-devel libpqxx-devel  
sudo yum install -y gcc-c++ autoconf automake libtool ncurses-devel zlib-devel libjpeg-devel openssl-devel e2fsprogs-devel sqlite-devel libcurl-devel pcre-devel speex-devel ldns-devel libedit-devel libxml2-devel libyuv-devel libvpx-devel libvpx2* libdb4* libidn-devel unbound-devel libuuid-devel lua-devel libsndfile-devel yasm-devel  
```
2. #### 安装sofia-sip
###### git地址可使用gitee镜像地址
```shell
cd /opt/
git clone https://github.com/freeswitch/sofia-sip
cd sofia-sip
./bootstrap.sh -j
./configure
make
make install
export PKG_CONFIG_PATH=/usr/local/lib/pkgconfig:${PKG_CONFIG_PATH}
ldconfig
```
3. #### 安装spandsp
###### git地址可使用gitee镜像地址
```shell
cd /opt/
git clone https://github.com/freeswitch/spandsp
cd spandsp
./bootstrap.sh -j
./configure
make
make install
ldconfig
```
4. #### 安装freeswitch
###### git地址可使用gitee镜像地址
```shell
cd /opt
git clone --branch v1.10.11 https://github.com/signalwire/freeswitch.git
cd /opt/freeswitch
./bootstrap.sh
sed -i 's/#formats\/mod_shout/formats\/mod_shout/g' /opt/freeswitch/modules.conf
sed -i 's/applications\/mod_signalwire/#applications\/mod_signalwire/g' /opt/freeswitch/modules.conf
sed -i 's/endpoints\/mod_verto/#endpoints\/mod_verto/g' /opt/freeswitch/modules.conf
sed -i 's/applications\/mod_av/#applications\/mod_av/g' /opt/freeswitch/modules.conf
sed -i 's/codecs\/mod_opus/#codecs\/mod_opus/g' /opt/freeswitch/modules.conf
sed -i 's/#applications\/mod_callcenter/applications\/mod_callcenter/g' /opt/freeswitch/modules.conf
sed -i 's/#applications\/mod_httapi/applications\/mod_httapi/g' /opt/freeswitch/modules.conf
sed -i 's/#event_handlers\/mod_odbc_cdr/event_handlers\/mod_odbc_cdr/g' /opt/freeswitch/modules.conf

./configure --enable-portable-binary --prefix=/usr/local/freeswitch --with-gnu-ld --with-python --with-openssl --enable-core-odbc-support --enable-zrtp
make
make install
make -j cd-sounds-install
make -j cd-moh-install
```
5. #### 安装G729 
```shell
cd /opt
git clone https://github.com/xadhoom/mod_bcg729.git
cd mod_bcg729
vim Makefile
FS_INCLUDES=/usr/local/freeswitch/include/freeswitch
make 
```
6. #### 连接数据库
```shell
yum install -y mysql-connector-odbc
vim /etc/odbcinst.ini 
[MySQL]
Description     = ODBC for MySQL
Driver          = /usr/lib/libmyodbc5.so
Setup           = /usr/lib/libodbcmyS.so
Driver64        = /usr/lib64/libmyodbc5.so
Setup64         = /usr/lib64/libodbcmyS.so
FileUsage       = 1

#sql连接
vim /etc/odbc.ini 
[freeswitch]
Driver          = /usr/lib64/libmyodbc5.so
SERVER       = 127.0.0.1
PORT           = 3306
DATABASE  = freeswitch
OPTION      = 67108864
USER           = root
PASSWORD  = 123456
Threading    = 0

#测试mysql连接
isql -v freeswitch

#修改mysql相关配置
cd /usr/local/freeswitch/etc/freeswitch/autoload_configs/
vim ./autoload_configs/switch.conf.xml 
vim ./autoload_configs/db.conf.xml 
vim ./sip_profiles/internal.xml 
<param name="core-db-dsn" value="freeswitch::" />
```
7. #### 启动freeswitch
```shell
#启动
freeswitch -nc
freeswitch -nc -nonat
```
8. #### 修改event_socket.conf
```shell
<settings>
    <param name="nat-map" value="false"/>
    <param name="listen-ip" value="127.0.0.1"/>
    <param name="listen-port" value="8021"/>
    <param name="password" value="123456"/>
    <!--<param name="apply-inbound-acl" value="loopback.auto"/>-->
    <!--<param name="stop-on-bind-error" value="true"/>-->
  </settings>
```