cmake_minimum_required(VERSION 3.10.2)
project("jmpeg")

#add_definitions(-D__STDC_FORMAT_MACROS)

message(WARNING "Operation system is ${CMAKE_SYSTEM}")
message(WARNING "CMAKE_BUILD_TYPE is ${CMAKE_BUILD_TYPE}")
message(WARNING "ANDROID_NDK is ${ANDROID_NDK}")
message(WARNING "ANDROID_ABI is ${ANDROID_ABI}")

#aux_source_directory(${CMAKE_SOURCE_DIR}/src/main/cpp SRC)
#aux_source_directory(${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI} IMPORT)

include_directories(${CMAKE_SOURCE_DIR}/src/main/jniLibs/include)
set(IMPORT ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI})
file(GLOB CPP_FILE_ALL *.cpp)

find_library(log-lib log)
add_library(avcodec-57 SHARED IMPORTED)
set_target_properties(avcodec-57 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libavcodec-57.so)

add_library(${PROJECT_NAME} SHARED ${CPP_FILE_ALL})

target_link_libraries(${PROJECT_NAME} avcodec-57 ${log-lib})

#cmake_minimum_required(VERSION 3.10.2)
#project(jmpeg VERSION 0.0.0)
#
#set(CMAKE_C_EXTENSIONS      ON)
#set(CMAKE_C_STANDARD        99)
#set(CMAKE_CXX_EXTENSIONS    ON)
#set(CMAKE_CXX_STANDARD      11)
#set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -pedantic -Werror")
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -pedantic -Werror")
#
#if (CMAKE_BUILD_TYPE STREQUAL Debug)
#    add_definitions(-DDEBUG)
#endif()

# 添加头文件位置
#include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include)
#include_directories(${CMAKE_CURRENT_SOURCE_DIR}/src)

# ffmpeg
#if(${CMAKE_SYSTEM_NAME} STREQUAL "Android")
#    set(FFmpeg_INCLUDE_DIRS ${CMAKE_SOURCE_DIR}/src//main/jniLibs/include)
#    include_directories(${FFmpeg_INCLUDE_DIRS})
#    add_library(avcodec SHARED IMPORTED)
#    set_target_properties(avcodec PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/src//main/jniLibs/${ANDROID_ABI}/libavcodec-57.so)
#elseif(${CMAKE_SYSTEM_NAME} STREQUAL "iOS")
#    set(FFmpeg_INCLUDE_DIRS ${PROJECT_SOURCE_DIR}/prebuilt/ffmpeg/ios/include)
#    include_directories(${FFmpeg_INCLUDE_DIRS})
#else()
#    # 系统库
#    include_directories("/usr/local/include")
#    link_directories("/usr/local/lib")
#endif()
#
#add_library(native-lib SHARED native-lib.cpp)
#
##add_subdirectory(src)
#
## 配置依赖的库文件
#if(${CMAKE_SYSTEM_NAME} STREQUAL "Android")
#    target_link_libraries(native-lib avcodec)
#else()
#    target_link_libraries(${PROJECT_NAME} pthread m avformat avcodec avutil swresample)
#endif()

