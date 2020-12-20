cmake_minimum_required(VERSION 3.10.2)
project("jmpeg")

#add_definitions(-D__STDC_FORMAT_MACROS)

message(WARNING "Operation system is ${CMAKE_SYSTEM}")
message(WARNING "CMAKE_BUILD_TYPE is ${CMAKE_BUILD_TYPE}")
message(WARNING "ANDROID_NDK is ${ANDROID_NDK}")
message(WARNING "ANDROID_ABI is ${ANDROID_ABI}")
#message(WARNING "Cmake dir is ${CMAKE_SOURCE_DIR}")

include_directories(${CMAKE_SOURCE_DIR}/../jniLibs/include)
set(IMPORT ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI})
file(GLOB CPP_FILE_ALL *.cpp)

find_library(log-lib log)

add_library(avcodec-57 SHARED IMPORTED)
set_target_properties(avcodec-57 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libavcodec-57.so)
add_library(avdevice-57 SHARED IMPORTED)
set_target_properties(avdevice-57 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libavdevice-57.so)
add_library(avfilter-6 SHARED IMPORTED)
set_target_properties(avfilter-6 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libavfilter-6.so)
add_library(avformat-57 SHARED IMPORTED)
set_target_properties(avformat-57 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libavformat-57.so)
add_library(avutil-55 SHARED IMPORTED)
set_target_properties(avutil-55 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libavutil-55.so)
add_library(postproc-54 SHARED IMPORTED)
set_target_properties(postproc-54 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libpostproc-54.so)
add_library(swresample-2 SHARED IMPORTED)
set_target_properties(swresample-2 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libswresample-2.so)
add_library(swscale-4 SHARED IMPORTED)
set_target_properties(swscale-4 PROPERTIES IMPORTED_LOCATION ${IMPORT}/libswscale-4.so)

add_library(${PROJECT_NAME} SHARED ${CPP_FILE_ALL})

target_link_libraries(${PROJECT_NAME} avcodec-57 avdevice-57 avfilter-6 avformat-57 avutil-55 postproc-54 swresample-2 swscale-4 ${log-lib})

