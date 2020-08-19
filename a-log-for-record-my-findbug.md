```
submit java -jar dgraph-1.0-SNAPSHOT.jar localhost 9080 findbug.gql 50 1
Hello world!
 java -jar target/dgraph-1.0-SNAPSHOT.jar localhost 9080 x.gql minLen maxTimes
args is :
localhost
9080
findbug.gql
50
1
GET GQL from findbug.gql
query x{
    settings(func: has(<APP#usersettings>)) @filter(eq(<APP#usersettings/userId>, <0_key@app.to.findbug.com>)){
        uid
       userId: <APP#usersettings/userId>
       nickname: <APP#usersettings/nickname>
    }
}
17:41:58.920 [main] DEBUG io.netty.util.internal.logging.InternalLoggerFactory - Using SLF4J as the default logging framework
17:41:58.930 [main] DEBUG io.netty.util.internal.PlatformDependent0 - -Dio.netty.noUnsafe: false
17:41:58.932 [main] DEBUG io.netty.util.internal.PlatformDependent0 - Java version: 8
17:41:58.934 [main] DEBUG io.netty.util.internal.PlatformDependent0 - sun.misc.Unsafe.theUnsafe: available
17:41:58.936 [main] DEBUG io.netty.util.internal.PlatformDependent0 - sun.misc.Unsafe.copyMemory: available
17:41:58.937 [main] DEBUG io.netty.util.internal.PlatformDependent0 - java.nio.Buffer.address: available
17:41:58.939 [main] DEBUG io.netty.util.internal.PlatformDependent0 - direct buffer constructor: available
17:41:58.942 [main] DEBUG io.netty.util.internal.PlatformDependent0 - java.nio.Bits.unaligned: available, true
17:41:58.942 [main] DEBUG io.netty.util.internal.PlatformDependent0 - jdk.internal.misc.Unsafe.allocateUninitializedArray(int): unavailable prior to Java9
17:41:58.942 [main] DEBUG io.netty.util.internal.PlatformDependent0 - java.nio.DirectByteBuffer.<init>(long, int): available
17:41:58.942 [main] DEBUG io.netty.util.internal.PlatformDependent - sun.misc.Unsafe: available
17:41:58.943 [main] DEBUG io.netty.util.internal.PlatformDependent - -Dio.netty.tmpdir: /tmp (java.io.tmpdir)
17:41:58.943 [main] DEBUG io.netty.util.internal.PlatformDependent - -Dio.netty.bitMode: 64 (sun.arch.data.model)
17:41:58.947 [main] DEBUG io.netty.util.internal.PlatformDependent - -Dio.netty.maxDirectMemory: 3709861888 bytes
17:41:58.948 [main] DEBUG io.netty.util.internal.PlatformDependent - -Dio.netty.uninitializedArrayAllocationThreshold: -1
17:41:58.950 [main] DEBUG io.netty.util.internal.CleanerJava6 - java.nio.ByteBuffer.cleaner(): available
17:41:58.951 [main] DEBUG io.netty.util.internal.PlatformDependent - -Dio.netty.noPreferDirect: false
17:41:59.058 [main] DEBUG io.netty.channel.MultithreadEventLoopGroup - -Dio.netty.eventLoopThreads: 8
17:41:59.099 [main] DEBUG io.netty.util.internal.InternalThreadLocalMap - -Dio.netty.threadLocalMap.stringBuilder.initialSize: 1024
17:41:59.099 [main] DEBUG io.netty.util.internal.InternalThreadLocalMap - -Dio.netty.threadLocalMap.stringBuilder.maxSize: 4096
17:41:59.109 [main] DEBUG io.netty.channel.nio.NioEventLoop - -Dio.netty.noKeySetOptimization: false
17:41:59.109 [main] DEBUG io.netty.channel.nio.NioEventLoop - -Dio.netty.selectorAutoRebuildThreshold: 512
17:41:59.130 [main] DEBUG io.netty.util.internal.PlatformDependent - org.jctools-core.MpscChunkedArrayQueue: available
17:41:59.164 [main] DEBUG io.netty.util.ResourceLeakDetector - -Dio.netty.leakDetection.level: simple
17:41:59.164 [main] DEBUG io.netty.util.ResourceLeakDetector - -Dio.netty.leakDetection.targetRecords: 4
17:41:59.165 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.numHeapArenas: 8
17:41:59.165 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.numDirectArenas: 8
17:41:59.165 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.pageSize: 8192
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.maxOrder: 11
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.chunkSize: 16777216
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.tinyCacheSize: 512
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.smallCacheSize: 256
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.normalCacheSize: 64
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.maxCachedBufferCapacity: 32768
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.cacheTrimInterval: 8192
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.cacheTrimIntervalMillis: 0
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.useCacheForAllThreads: true
17:41:59.166 [main] DEBUG io.netty.buffer.PooledByteBufAllocator - -Dio.netty.allocator.maxCachedByteBuffersPerChunk: 1023
17:41:59.177 [main] DEBUG io.netty.buffer.ByteBufUtil - -Dio.netty.allocator.type: pooled
17:41:59.178 [main] DEBUG io.netty.buffer.ByteBufUtil - -Dio.netty.threadLocalDirectBufferSize: 0
17:41:59.178 [main] DEBUG io.netty.buffer.ByteBufUtil - -Dio.netty.maxThreadLocalCharBufferSize: 16384
17:41:59.537 [grpc-default-executor-0] DEBUG io.netty.buffer.AbstractByteBuf - -Dio.netty.buffer.checkAccessible: true
17:41:59.537 [grpc-default-executor-0] DEBUG io.netty.buffer.AbstractByteBuf - -Dio.netty.buffer.checkBounds: true
17:41:59.538 [grpc-default-executor-0] DEBUG io.netty.util.ResourceLeakDetectorFactory - Loaded default ResourceLeakDetector: io.netty.util.ResourceLeakDetector@2a856f8e
17:41:59.618 [grpc-default-executor-0] DEBUG io.netty.channel.DefaultChannelId - -Dio.netty.processId: 24239 (auto-detected)
17:41:59.620 [grpc-default-executor-0] DEBUG io.netty.util.NetUtil - -Djava.net.preferIPv4Stack: false
17:41:59.620 [grpc-default-executor-0] DEBUG io.netty.util.NetUtil - -Djava.net.preferIPv6Addresses: false
17:41:59.623 [grpc-default-executor-0] DEBUG io.netty.util.NetUtil - Loopback interface: lo (lo, 0:0:0:0:0:0:0:1%lo)
17:41:59.624 [grpc-default-executor-0] DEBUG io.netty.util.NetUtil - /proc/sys/net/core/somaxconn: 128
17:41:59.626 [grpc-default-executor-0] DEBUG io.netty.channel.DefaultChannelId - -Dio.netty.machineId: a8:6b:ad:ff:fe:07:31:db (auto-detected)
17:41:59.677 [grpc-default-executor-0] DEBUG io.netty.util.Recycler - -Dio.netty.recycler.maxCapacityPerThread: 4096
17:41:59.677 [grpc-default-executor-0] DEBUG io.netty.util.Recycler - -Dio.netty.recycler.maxSharedCapacityFactor: 2
17:41:59.677 [grpc-default-executor-0] DEBUG io.netty.util.Recycler - -Dio.netty.recycler.linkCapacity: 16
17:41:59.677 [grpc-default-executor-0] DEBUG io.netty.util.Recycler - -Dio.netty.recycler.ratio: 8
17:41:59.703 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] OUTBOUND SETTINGS: ack=false settings={ENABLE_PUSH=0, MAX_CONCURRENT_STREAMS=0, INITIAL_WINDOW_SIZE=1048576, MAX_HEADER_LIST_SIZE=8192}
17:41:59.715 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] OUTBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
17:41:59.725 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] INBOUND SETTINGS: ack=false settings={MAX_CONCURRENT_STREAMS=1000}
17:41:59.726 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] OUTBOUND SETTINGS: ack=true
17:41:59.728 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] INBOUND SETTINGS: ack=true
17:41:59.769 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] OUTBOUND HEADERS: streamId=3 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9080, :path: /api.Dgraph/Query, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.26.0, grpc-accept-encoding: gzip] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
17:41:59.782 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] OUTBOUND DATA: streamId=3 padding=0 endStream=true length=234 bytes=00000000e522e201717565727920787b0a2020202073657474696e67732866756e633a20686173283c415050237573657273657474696e67733e292920406669...
17:41:59.785 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] INBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=234
17:41:59.786 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] INBOUND PING: ack=false bytes=145258749040133895
17:41:59.786 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] OUTBOUND PING: ack=true bytes=145258749040133895
17:42:00.103 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc] padding=0 endStream=false
17:42:00.107 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] INBOUND DATA: streamId=3 padding=0 endStream=false length=144 bytes=000000008b0a0f7b2273657474696e6773223a5b5d7d120208471a1708859f051081deb1960118b71320a5e4232897a3df9601225b0a070a0375696410000a1b...
17:42:00.111 [grpc-nio-worker-ELG-1-2] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xf5dc7109, L:/127.0.0.1:60092 - R:localhost/127.0.0.1:9080] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[grpc-status: 0, grpc-message: ] padding=0 endStream=true
17:42:00.124 [main] INFO app.findbug.DGraphService - query is 
query x{
    settings(func: has(<APP#usersettings>)) @filter(eq(<APP#usersettings/userId>, <0_key@app.to.findbug.com>)){
        uid
       userId: <APP#usersettings/userId>
       nickname: <APP#usersettings/nickname>
    }
}
 ,and response time is: 
StopWatch '': running time = 798346027 ns
---------------------------------------------
ns         %     Task name
---------------------------------------------
798346027  100%  Query and Response 

GET RESPONSE 
{"settings":[]}
Length is 15
17:42:00.130 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] OUTBOUND SETTINGS: ack=false settings={ENABLE_PUSH=0, MAX_CONCURRENT_STREAMS=0, INITIAL_WINDOW_SIZE=1048576, MAX_HEADER_LIST_SIZE=8192}
17:42:00.131 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] OUTBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=983041
17:42:00.132 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] INBOUND SETTINGS: ack=false settings={MAX_CONCURRENT_STREAMS=1000}
17:42:00.132 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] OUTBOUND SETTINGS: ack=true
17:42:00.133 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] INBOUND SETTINGS: ack=true
17:42:00.134 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] OUTBOUND HEADERS: streamId=3 headers=GrpcHttp2OutboundHeaders[:authority: localhost:9080, :path: /api.Dgraph/Query, :method: POST, :scheme: http, content-type: application/grpc, te: trailers, user-agent: grpc-java-netty/1.26.0, grpc-accept-encoding: gzip] streamDependency=0 weight=16 exclusive=false padding=0 endStream=false
17:42:00.135 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] OUTBOUND DATA: streamId=3 padding=0 endStream=true length=234 bytes=00000000e522e201717565727920787b0a2020202073657474696e67732866756e633a20686173283c415050237573657273657474696e67733e292920406669...
17:42:00.137 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] INBOUND WINDOW_UPDATE: streamId=0 windowSizeIncrement=234
17:42:00.137 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] INBOUND PING: ack=false bytes=145258749040133895
17:42:00.137 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] OUTBOUND PING: ack=true bytes=145258749040133895
17:42:00.487 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[:status: 200, content-type: application/grpc] padding=0 endStream=false
17:42:00.487 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] INBOUND DATA: streamId=3 padding=0 endStream=false length=144 bytes=000000008b0a0f7b2273657474696e6773223a5b5d7d120208481a1708cac00610c5c79ea60118c01a20dcdb4328e3a8eea601225b0a1d0a1941505023757365...
17:42:00.488 [grpc-nio-worker-ELG-1-4] DEBUG io.grpc.netty.NettyClientHandler - [id: 0xad5e3929, L:/127.0.0.1:60094 - R:localhost/127.0.0.1:9080] INBOUND HEADERS: streamId=3 headers=GrpcHttp2ResponseHeaders[grpc-status: 0, grpc-message: ] padding=0 endStream=true
17:42:00.488 [main] INFO app.findbug.DGraphService - query is 
query x{
    settings(func: has(<APP#usersettings>)) @filter(eq(<APP#usersettings/userId>, <0_key@app.to.findbug.com>)){
        uid
       userId: <APP#usersettings/userId>
       nickname: <APP#usersettings/nickname>
    }
}
 ,and response time is: 
StopWatch '': running time = 361417637 ns
---------------------------------------------
ns         %     Task name
---------------------------------------------
361417637  100%  Query and Response 

{"settings":[]}
Response Length is 15
Find it !
Over!
➜  submit 
```